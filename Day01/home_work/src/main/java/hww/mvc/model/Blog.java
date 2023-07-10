package hww.mvc.model;

public class Blog {
    private  int id;
    private String name;
    private String category;
    private String topic;
    private int idListComment;

    public Blog(int id, String name, String category, String topic, int idListComment) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.topic = topic;
        this.idListComment = idListComment;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getIdListComment() {
        return idListComment;
    }

    public void setIdListComment(int idListComment) {
        this.idListComment = idListComment;
    }
}
