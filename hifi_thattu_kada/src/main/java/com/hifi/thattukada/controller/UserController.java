package com.hifi.thattukada.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hifi.thattukada.config.HibernateConfigurer;
import com.hifi.thattukada.variety.dao.UserDao;
import com.hifi.thattukada.variety.entity.UserEntity;
import com.hifi.thattukada.variety.pojo.UserDetailsPojo;
import com.hifi.thattukada.variety.vo.UserVO;

@Controller
@Import(HibernateConfigurer.class)
public class UserController {

	/*
	 * private final Logger logger ; logger =
	 * LoggerFactory.getLogger(UserController.class);
	 */
	@Autowired
	private UserDao userDao;

	// @Autowired
	// private UserDetailsPojo userPojo;
	// AnnotationConfigWebApplicationContext ctx = new
	// AnnotationConfigWebApplicationContext();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexPage() {
		System.out.println("\n\n --USER CONTROLLER STARTED-- \n\n");
		return new ModelAndView("index");
		// return new ModelAndView("home");
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome(Model model) {
		System.out.println("\n\n --USER redirect CONTROLLER STARTED-- \n\n");
		return new ModelAndView("welcome", "userPojo", new UserEntity());
		// return new ModelAndView("home");
	}

	@RequestMapping("/loginList")
	public List<UserEntity> getList() {
		// UserDao userDao = ctx.getBean(UserDao.class);
		@SuppressWarnings("unchecked")
		List<UserEntity> retunList = this.userDao.userList();
		System.out.println("/n/n LISt--->>" + retunList);
		return retunList;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	// public ModelAndView home(Model m){
	// System.out.println("\n \n HOME Controller\n \n");
	// ModelAndView modelAndView = new ModelAndView("home");
	// // // modelAndView.addObject("userEntity", new UserEntity());
	// m.addAttribute("userEntity",new UserEntity());
	// return modelAndView;
	// }
	public ModelAndView home(@Valid UserDetailsPojo logpo, BindingResult br) {
		System.out.println("\n \n HOME Controller\n \n");
		ModelAndView mav = new ModelAndView("home", "userPojo",
				new UserDetailsPojo());

		if (br.hasErrors()) {
			mav.setViewName("error");
		}
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView userRegister(
			@ModelAttribute("userPojo") UserEntity userPojo,
			HttpServletRequest request, BindingResult result, Model m) {
		System.out.println("\n \n REGISTER Controller\n \n");

		String FORWARD = null;
		UserVO userVo = new UserVO();
		// String uname = (String)request.getParameter("uvc_user_name").trim();
		String uname = userPojo.getUvc_user_name().replaceAll(",", "");
		System.out.println("\n\n uname-->>" + uname);
		// String passwd = (String)request.getParameter("vc_passwd").trim();
		String passwd = userPojo.getVc_passwd().replaceAll(",", "");
		System.out.println("usrPasswd-->>" + passwd);
		// String regEmail = (String)request.getParameter("uvc_email").trim();
		String regEmail = userPojo.getUvc_email().replaceAll(",", "");
		System.out.println("usrPasswd-->>" + regEmail);
		String sendUpdates = (String) request.getParameter("b_sendUpdates");
		System.out.println("sendUpdates-->" + sendUpdates);
		System.out.println("\n\n");

		if (!uname.equals(null) && !passwd.equals(null)
				&& !regEmail.equals(null)) {
			userVo.setUser_name(uname);
			userVo.setUser_password(passwd);
			userVo.setUser_email(regEmail);

			if (sendUpdates.equals(true))
				userVo.setSend_updates(true);

			ModelAndView mav = new ModelAndView();
			String message = this.userDao.userRegister(userVo, userPojo);
			System.out.println("\n\nMESSAGE in CONTROLLER-->>" + message);

			// ((Model) mav).addAttribute("user", new UserEntity());
			if (message.equals("USER CREATED")) {
				FORWARD = "home";
			} else {
				FORWARD = "welcome";
			}
			mav.addObject("message", message);
		}
		m.addAttribute("message", "Successfully saved person ");
		return new ModelAndView(FORWARD);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(HttpServletRequest request) {

		System.out.println("\n \n LOGIN Controller\n \n");
		String FORWARD = null;
		boolean userLoginFlag = false;
		UserVO userVo = new UserVO();
		String uname = (String) request.getParameter("userName").trim();
		System.out.println("\n\n uname-->>" + uname);
		String passwd = (String) request.getParameter("usrPasswd").trim();
		System.out.println("usrPasswd-->>" + passwd);
		System.out.println("\n\n");

		if (!uname.equals(null) && !passwd.equals(null)) {
			userVo.setUser_name(uname);
			userVo.setUser_password(passwd);
			System.out.println("\n\n INSIDE IF CONTROLLER \n\n");
			/*
			 * @SuppressWarnings("unchecked") ArrayList<UserEntity> userList
			 * =(ArrayList<UserEntity>) this.userDao.userList();
			 * 
			 * if (userList.size()>0){
			 * 
			 * for(int i = 0;i<=userList.size();i++){
			 * System.out.println("list UserDao IMP-->>>"+userList.get(i)); }
			 * 
			 * } System.out.println("USER LIST-->>"+userList);
			 */
			userLoginFlag = this.userDao.userLogin(userVo);
			if (userLoginFlag) {
				FORWARD = "home";
				System.out.println("\n\n  LOGIn CONTROLLER TRUE \n\n");

			} else {
				FORWARD = "welcome";
				System.out.println("\n\n  LOGIn CONTROLLER false \n\n");
			}

		} else {
			FORWARD = "welcome";
			System.out.println("\n\n  USR NAME OR PASS NULL \n\n");
		}
		System.out.println("FORWARD---::"+FORWARD);
		return new ModelAndView(FORWARD, "userPojo", new UserDetailsPojo());
	}

	/*
	 * @RequestMapping(value="/login") public void list(){
	 * System.out.println("USER CONTROLLER LIST -->"+ userService.getList()); }
	 */

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void securityForward() {
		System.out.println("\n USER CONTROLLER.securityForward");
		// ModelAndView mav = new ModelAndView("index");
		// return mav;
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public void securityTest() {
		System.out.println("\n USER CONTROLLER.securityForward");
		// ModelAndView mav = new ModelAndView("index");
		// return mav;
	}
}
