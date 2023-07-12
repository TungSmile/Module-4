package hww.mvc.controller;
import hww.mvc.model.Blog;
import hww.mvc.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
// @RequestMapping dùng để kiểm soát toàn bộ request đi vào class (chú ý  / vì dễ gây nhầm lẫn)
public class BlogController {
    @Autowired
    BlogService bs = new BlogService();

    @GetMapping()
    public String showAllBlog(Model model) {
        model.addAttribute("list", bs.getAllBlog());
        return "Home";
    }

    @GetMapping("/edit/{id}")
    public String swapToEdit(@PathVariable int id, Model model) {
        // PathVariable lấy giá trị từ đường uri khi đc truyền vào
        model.addAttribute("Blog", bs.findByID(id));
        return "Edit";
    }

    @PostMapping("/edit")
    public String editBlog(int id, Blog blog) {
        bs.editBlogByID(id, blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete")

    public String delete(int id) {
        bs.deleteBlog(id);
        return "redirect:/blog";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("Blog", bs.findByID(id));
        return "One";
    }

}


