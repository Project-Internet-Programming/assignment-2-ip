import java.awt.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dbUtil.HibernateCF;
import dbUtil.InstructorDAO;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

    private static final String HebernateCF = null;

	@RequestMapping("/getAll")
    public ModelAndView getAll(Model model) {
        Object instructorService;
		List<Instructor> instructorList = instructorService.getAllInstructors();
        ModelAndView modelAndView = new ModelAndView("instructorList");
        modelAndView.addObject("instructors", instructorList);
        return modelAndView;
    }


	@RequestMapping("/getById")
		public String getById(HttpServletRequest request, Model model) {
		    Session session = HibernateCF.getSessionFactory().openSession();
		    int id = Integer.parseInt(request.getParameter("id"));
		    Program program = session.get(Program.class, id);
		    model.addAttribute("program", program);
		    return "ProgramDisplayInfo";
}

	@RequestMapping("/add")
	public String add() {
	    return "addInstructorForm";
	}

	@RequestMapping("/processAdd")
	public ModelAndView processAdd(HttpServletRequest request) {
	    Instructor instructor = new Instructor();
	    instructor.setName(request.getParameter("name"));
	    instructor.setGender(request.getParameter("gender"));
	    instructor.setSpeciality(request.getParameter("speciality"));

	    InstructorDAO insdao = new InstructorDAO();
	    int rowCount = insdao.add(instructor);

	    ModelAndView modelAndView = new ModelAndView("addInstructorResult");
	    modelAndView.addObject("rowCount", rowCount);

	    return modelAndView;
	}

	@RequestMapping("/update")
	public String update() {
	    return "updateProgramForm";
	}

	@RequestMapping("/processUpdate")
	public ModelAndView processUpdate(HttpServletRequest request) {
	    Session session = HebernateCF.getSessionFactory().openSession();
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    Program programToUpdate = session.get(Program.class, id);
	    
	    if (programToUpdate != null) {
	        programToUpdate.setName(request.getParameter("name"));
	        programToUpdate.setNote(request.getParameter("note"));

	        session.beginTransaction();
	        session.update(programToUpdate);
	        session.getTransaction().commit();
	        
	        ModelAndView modelAndView = new ModelAndView("updateProgramResult");
	        modelAndView.addObject("message", "Program updated successfully");
	        return modelAndView;
	    } else {
	        ModelAndView modelAndView = new ModelAndView("updateProgramResult");
	        modelAndView.addObject("message", "Program not found");
	        return modelAndView;
	    }
	}

	@RequestMapping("/delete") 
	public String delete(HttpServletRequest request) {
	    Session session = HibernateCF.getSessionFactory().openSession();
	    int id = Integer.parseInt(request.getParameter("id"));
	    Program programToDelete = session.get(Program.class, id);

	    if (programToDelete != null) {
	        session.beginTransaction();
	        session.delete(programToDelete);
	        session.getTransaction().commit();
	        
	        return "redirect:/instructor/deleteResult?id=" + id;
	    } else {
	        return "redirect:/instructor/deleteResult?id=" + id + "&notFound=true";
	    }
	}

}	