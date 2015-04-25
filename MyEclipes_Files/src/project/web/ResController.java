package project.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.model.Project;
import project.model.Res;
import project.model.User;
import project.service.IResService;

@Controller
@RequestMapping("/project/res")
public class ResController {
	private IResService resService;

	public IResService getResService() {
		return resService;
	}
	
	@Resource
	public void setResService(IResService resService) {
		this.resService = resService;
	}

	@RequestMapping(value={"/reslists","/"},method=RequestMethod.GET)
	public String list(Model model,HttpSession hs) {
		User u = new User();
		u=(User) hs.getAttribute("loginUser");
		model.addAttribute("pagers", resService.findByUid(u.getUid()));
		return "project/res/reslist";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new Res());
		return "project/res/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated Res res,BindingResult br,HttpSession hs) {
		if(br.hasErrors()) {
			return "project/res/add";
		}
		User u = new User();
		u=(User) hs.getAttribute("loginUser");
		res.setUid(u.getUid());
		resService.add(res);
		return "redirect:/project/res/reslists";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model) {
		model.addAttribute(resService.load(id));
		return "project/res/show";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute(resService.load(id));
		return "project/res/update";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated Res res,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "project/res/update";
		}
		Res r = resService.load(id);
		r.setRname(res.getRname());
		r.setRmoney(res.getRmoney());
		resService.update(r);
		
		return "redirect:/project/res/reslists";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		resService.delete(id);
		return "redirect:/project/res/reslists";
	}
}
