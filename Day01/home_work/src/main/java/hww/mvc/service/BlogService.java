package hww.mvc.service;

import hww.mvc.model.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogService {
    List<Blog> list = new ArrayList<>();

    public BlogService() {
        list.add(new Blog(1, "NguyenVanA", "chem gio", "test", 1));
        list.add(new Blog(2, "NguyenVanA", "chem gio", "test", 2));
        list.add(new Blog(3, "NguyenVanA", "chem gio", "test", 3));
    }


    public List<Blog> getAllBlog() {
        return list;
    }

    public Blog findByID(int id) {
        for (Blog o : list) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

    public void createBlog(Blog blog) {
        list.add(blog);
    }

    public void editBlogByID(int id, Blog blog) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.set(i, blog);
                break;
            }
        }
    }

    public void deleteBlog(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(list.get(i));
                break;
            }
        }
    }

}
