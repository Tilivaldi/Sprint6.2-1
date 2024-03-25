package TO_G1Spring61.demo.controller;

import TO_G1Spring61.demo.model.Course;
import TO_G1Spring61.demo.model.Request;
import TO_G1Spring61.demo.service.CourseService;
import TO_G1Spring61.demo.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private RequestService requestService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String indexPage(Model model){
        List<Request> requests = requestService.getSortedRequests();
        model.addAttribute("requests", requests);

        List<Course> courses = courseService.getCourse();
        model.addAttribute("courses", courses);
        return "index";
    }

    @GetMapping("/handled")
    public String handledPage(Model model){
        List<Request> requests = requestService.getSortedRequests();
        model.addAttribute("requests", requests);
        return "handled";
    }

    @GetMapping("/not-handled")
    public String notHandledPage(Model model){
        List<Request> requests = requestService.getSortedRequests();
        model.addAttribute("requests", requests);
        return "not-handled";
    }

    @GetMapping( "/add-request")
    public String addRequests(Model model){
        List<Request> requests = requestService.getSortedRequests();
        model.addAttribute("requests", requests);

        List<Course> courses = courseService.getCourse();
        model.addAttribute("courses", courses);
        return "add";
    }

    @PostMapping("/requests/add")
    public String addRequest(Request request) {
        requestService.addRequest(request);
        return "redirect:/";
    }

    @PostMapping("/requests/edit")
    public String editRequest(Request request) {
        requestService.editRequest(request);
        return "redirect:/";
    }

    @PostMapping("/requests/delete")
    public String editDeveloper(Request request) {
        requestService.deleteRequest(request.getId());
        return "redirect:/";
    }

    @GetMapping("/requests/{id}")
    public String detailsPage(@PathVariable Long id, Model model) {
        Request request = requestService.getRequestsById(id);
        model.addAttribute("request", request);

        List<Course> courses = courseService.getCourse();
        model.addAttribute("courses", courses);
        return "details";
    }




}