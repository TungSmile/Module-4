package hww.mvc.controller;

import hww.mvc.model.Blog;
import hww.mvc.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    BlogService bs = new BlogService();

    @GetMapping("/home")
    public String showAllBlog(Model model) {
        model.addAttribute("list", bs.getAllBlog());
        return "Home";
    }

    @GetMapping("/edit")
    public String swapToEdit(int id, Model model) {
        model.addAttribute("Blog", bs.findByID(id));
        return "Edit";
    }

    @PostMapping("/edit")
    public String editBlog(int id, Blog blog) {
        bs.editBlogByID(id, blog);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String delete(int id) {
        bs.deleteBlog(id);
        return "redirect:/home";
    }
}


