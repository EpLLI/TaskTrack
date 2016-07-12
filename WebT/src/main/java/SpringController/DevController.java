package SpringController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SpringSessionContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import test.z.pojos.Comment;
import test.z.pojos.Task;
import test.z.pojos.User;
import test.z.service.IAdminService;
import test.z.service.ICommentService;
import test.z.service.IProjectService;
import test.z.service.ITaskService;
import test.z.serviceException.ServiceException;

/** This controller controls the Developer methods */
@Controller
public class DevController {
	private static Logger log = Logger.getLogger(DevController.class);
	String url = null;
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IProjectService projectService;
	@Autowired
	private ITaskService taskService;
	@Autowired
	private ICommentService commService;
	/** Method for view the list of task and add comment*/
	@RequestMapping(value = "/Comment", method = RequestMethod.GET)
	public String mainProject(ModelMap model) {

		displayTask(model);

		return "view/comment";
	}
	/** Method for view the list of comments */
	@RequestMapping(value = "/Comments", method = RequestMethod.GET)
	public String mainComments(ModelMap model, @RequestParam("Name") String t) {
		displayTask(model);
		List<Comment> comm = null;
		try {
			comm = commService.getCommentTask(t);
		} catch (ServiceException e) {
			log.error(e);
		}
		model.put("comm", comm);

		return "view/comments";
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
	/** Method for add comment */
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("Comm") @Valid Comment comm, BindingResult br, ModelMap model,
			@RequestParam("t") String t) {

		if (!br.hasErrors()) {
			try {
				comm.setProject((String) taskService.getTask(t).getProject());
				comm.setTask((String) taskService.getTask(t).getName());

			} catch (ServiceException e1) {
				e1.printStackTrace();
				log.error("error in AddCommand/execute: " + e1);
			}

			try {
				commService.addComment(comm);
				;
			} catch (ServiceException e) {
				log.error("error in AddCommand/execute: " + e);
				e.printStackTrace();
			}

		}
		return "view";
	}
	/** Method for update status */
	@RequestMapping(value = "/UpdateStatusTask", method = RequestMethod.POST)
	public String UpdateDev(@ModelAttribute("Task") Task task, ModelMap model, BindingResult br,
			@RequestParam("h") String t, @RequestParam("j") String s) {
		if (!br.hasErrors()) {
			task.setName((String) t);
			task.setStatus((String) s);

			try {
				taskService.updateTask(task);

			} catch (ServiceException e) {

				log.error(e);
			}
		}
		return "view";
	}
	/** Method for delete the comment */
	@RequestMapping(value = "/deletecom", method = RequestMethod.GET)
	public String delete(HttpSession session, @RequestParam("id") int a) throws ServiceException {

		commService.remove(a);

		return "web/success";
	}
	/** Method for update the comment */
	@RequestMapping(value = "/UpdateComm", method = RequestMethod.POST)
	public String UpdateComment(@ModelAttribute("сommen") Comment commen, ModelMap model) {
		
		displayTask(model);
		
		try {
			commService.updateComm(commen);

		} catch (ServiceException e) {

			log.error(e);
		}
		return "view/comment";
	}
}
