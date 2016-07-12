package SpringController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import test.z.pojos.Project;
import test.z.pojos.Task;
import test.z.pojos.User;
import test.z.service.IAdminService;
import test.z.service.ILoginService;
import test.z.service.IProjectService;
import test.z.service.ITaskService;
import test.z.serviceException.ServiceException;

/** This controller controls the Manager methods */
@Controller
public class AdminController {
	private static Logger log = Logger.getLogger(AdminController.class);
	String url = null;
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IProjectService projectService;
	@Autowired
	private ITaskService taskService;

	/** Method for view the list of developers */
	@RequestMapping(value = "/Developers", method = RequestMethod.GET)
	public String mainMenu(ModelMap model) {
		displayUser(model);
		return "view/develop";
	}
	/** Method for add User */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(HttpSession session, ModelMap model, @ModelAttribute("user") @Valid User user,
			BindingResult br) throws ServiceException {
		String page = null;
		displayProject(model);
		try {
			if (!br.hasErrors()) {
				adminService.addUser(user);
			}
		} catch (ServiceException e) {
			log.error(e);
		}
		return page = "view";
	}
	/** Method for view the list of User */
	private void displayUser(ModelMap model) {
		List<User> user = null;
		try {
			user = adminService.getAllUser();
		} catch (ServiceException e) {
			log.error(e);
		}
		model.put("user", user);

	}
	/** Method for view the list of Project and Task */
	@RequestMapping(value = "/Project", method = RequestMethod.GET)
	public String mainProject(ModelMap model) {
		displayProject(model);
		displayTask(model);
		displayDev(model);
		return "view/project";
	}
	/** Method for view the list of User */
	private void displayProject(ModelMap model) {
		List<Project> proj = null;
		try {
			proj = projectService.getAllProject();
		} catch (ServiceException e) {
			log.error(e);
		}
		model.put("proj", proj);

	}

	private void displayTask(ModelMap model) {
		List<Task> task = null;
		try {
			task = taskService.getAllTask();
		} catch (ServiceException e) {
			log.error(e);
		}
		model.put("task", task);

	}
	/** Method for view the list of Developer */
	private void displayDev(ModelMap model) {
		List<User> user = null;
		try {
			user = adminService.getAllDev();
		} catch (ServiceException e) {
			log.error(e);
		}
		model.put("dev", user);

	}
	/** Method for add Project */
	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public String addProject(HttpSession session, ModelMap model, @ModelAttribute("proj") @Valid Project proj,
			BindingResult br) throws ServiceException {
		String page = null;
		try {
			if (!br.hasErrors()) {
				projectService.addProject(proj);
				;
			}
		} catch (ServiceException e) {
			log.error(e);
		}
		return page = "view";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String mainMenu() {
		return "view/menu";
	}
	/** Method for logout */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login";
	}
	/** Method for logout */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpSession session, @RequestParam("id") String a) throws ServiceException {

		Integer x = Integer.parseInt(a);
		System.out.println("а: " + x);
		adminService.remove(x);

		return "web/success";
	}
	/** Method to upgrade the role of the developer */
	@RequestMapping(value = "/UpdateDev", method = RequestMethod.POST)
	public String UpdateDev(@ModelAttribute("user") User user, ModelMap model) {

		try {
			adminService.updateDev(user);
			displayUser(model);

		} catch (ServiceException e) {

			log.error(e);
		}
		return "view/develop";
	}
	/** Method for add Task */
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public String addTask(@ModelAttribute("Task") @Valid Task task, BindingResult br, ModelMap model,
			@RequestParam("g") String g, @RequestParam("s") String s) {

		if (!br.hasErrors()) {
			try {
				task.setProject((String) projectService.getProject(g).getName());
				task.setStatus((String) s);
			} catch (ServiceException e1) {
				e1.printStackTrace();
				log.error("error in AddCommand/execute: " + e1);
			}

			try {
				taskService.addTask(task);
				;
			} catch (ServiceException e) {
				log.error("error in AddCommand/execute: " + e);
				e.printStackTrace();
			}

		}
		return "view";
	}
	/** Method for the purpose task */
	@RequestMapping(value = "/addDevTask", method = RequestMethod.POST)
	public String UpdateDeveloperTask(@ModelAttribute("task") Task task, ModelMap model, @RequestParam("t") String t,
			@RequestParam("d") String d) {

		task.setName((String) t);
		task.setDeveloper((String) d);
		try {
			taskService.addDeveloperTask(task);

		} catch (ServiceException e) {

			log.error(e);
		}
		return "view";
	}
}
