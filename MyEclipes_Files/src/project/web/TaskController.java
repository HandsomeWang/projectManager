package project.web;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.model.Disres;
import project.model.Project;
import project.model.Res;
import project.model.Task;
import project.model.User;
import project.service.IDisresService;
import project.service.IResService;
import project.service.ITaskService;

@Controller
@RequestMapping("/project/task")
public class TaskController {
	private ITaskService taskService;
	private IResService resService;
	private IDisresService disresService;

	
	public IDisresService getDisresService() {
		return disresService;
	}
	@Resource
	public void setDisresService(IDisresService disresService) {
		this.disresService = disresService;
	}

	public ITaskService getTaskService() {
		return taskService;
	}
	
	@Resource
	public void setTaskService(ITaskService taskService) {
		this.taskService = taskService;
	}
	
	

	public IResService getResService() {
		return resService;
	}
	@Resource
	public void setResService(IResService resService) {
		this.resService = resService;
	}

	@RequestMapping(value={"/tasklists","/"},method=RequestMethod.GET)
	public String list(Model model,HttpSession hs) {
		
		Project p = (Project) hs.getAttribute("p");
		int pid = p.getPid();
//		String pname=p.getPname();
//		System.out.println(pname+"------------pname");
//		model.addAttribute("p",p);
		model.addAttribute("pagers", taskService.findByPid(pid));
		return "project/task/tasklist";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		
		model.addAttribute(new Task());
		return "project/task/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated Task task,BindingResult br,HttpSession hs) {
		if(br.hasErrors()) {
			return "project/task/add";
		}
		Project p = (Project) hs.getAttribute("p");
		int pid = p.getPid();
		task.setPid(pid);
		taskService.add(task);
		return "redirect:/project/task/tasklists";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model) {
		model.addAttribute(taskService.load(id));
		List<Disres> listdis = disresService.listByTid(id);
		Iterator<Disres> it = listdis.iterator();
		String s = new String();
		while(it.hasNext()){
			int rid = it.next().getRid();
			Res res = resService.load(rid);
			s=s+res.getRname()+" ";
		}
		model.addAttribute("resnames",s);
		return "project/task/show";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute(taskService.load(id));
		return "project/task/update";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated Task task,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "project/task/update";
		}
		Task t = taskService.load(id);
		t.setTname(task.getTname());
		t.setTspend(task.getTspend());
		t.setTyear(task.getTyear());
		t.setTmonth(task.getTmonth());
		t.setTday(task.getTday());
		t.setTafter(task.getTafter());
		t.setTtype(task.getTtype());
		taskService.update(t);
		
		return "redirect:/project/task/tasklists";
	}
	@RequestMapping(value="/{id}/disres",method=RequestMethod.GET)
	public String disres(@PathVariable int id,Model model,HttpSession hs) {
		User u = (User) hs.getAttribute("loginUser");
		List<Res> listRes = resService.listByUid(u.getUid());
		model.addAttribute("listRes", listRes);
		
		Task t = taskService.load(id);
		String tname = t.getTname();
		model.addAttribute("tname",tname);
		return "project/task/disres";
	}
	
	@RequestMapping(value="/{id}/disres",method=RequestMethod.POST)
	public String disres(@PathVariable int id, HttpServletRequest hsq) {
		String[] myres=hsq.getParameterValues("myres");
		for(int i=0;i<myres.length;i++){
			Disres dr = new Disres();
			dr.setTid(id);
			dr.setRid(Integer.parseInt(myres[i]));
			disresService.add(dr);
		}
		
		return "redirect:/project/task/tasklists";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		taskService.delete(id);
		return "redirect:/project/task/tasklists";
	}
}
