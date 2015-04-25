package project.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.model.Project;
import project.model.User;
import project.service.IProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	private IProjectService projectService;

	public IProjectService getProjectService() {
		return projectService;
	}
	
	@Resource
	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}

	@RequestMapping(value={"/projects","/"},method=RequestMethod.GET)
	public String list(Model model,HttpSession hs) {
		User u = (User) hs.getAttribute("loginUser");
		model.addAttribute("pagers", projectService.findByUid(u.getUid()));
		return "project/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new Project());
		return "project/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated Project project,BindingResult br,HttpSession hs) {
		if(br.hasErrors()) {
			return "project/add";
		}
		User u = (User) hs.getAttribute("loginUser");
		project.setUid(u.getUid());
		projectService.add(project);
		return "redirect:/project/projects";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id,HttpSession hs) {
		Project p =projectService.load(id);
		hs.setAttribute("p", p);
	//	model.addAttribute("p", p);
		return "redirect:/project/task/tasklists";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute(projectService.load(id));
		return "project/update";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated Project project,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "project/update";
		}
		Project p = projectService.load(id);
		p.setPname(project.getPname());
		p.setPdate(project.getPdate());
		p.setPspend(project.getPspend());
		projectService.update(p);
		return "redirect:/project/projects";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		projectService.delete(id);
		return "redirect:/project/projects";
	}
}
