package com.zopr.widget.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zorana on 2/20/16.
 */
public class Comment implements Serializable {

    private static final long serialVersionUID = -1546377046890793898L;


    private Integer id;
    private String name;
    private String text;
    private Date posted;


    // Getters and Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonSerialize(using=DateSerializer.class)
    public Date getPosted() {
        return posted;
    }

    @JsonDeserialize(using=DateDeserializers.DateDeserializer.class)
    public void setPosted(Date posted) {
        this.posted = posted;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Comment [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", text=");
        builder.append(text);
        builder.append(", posted=");
        builder.append(posted);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        if (name != null ? !name.equals(comment.name) : comment.name != null) return false;
        if (posted != null ? !posted.equals(comment.posted) : comment.posted != null) return false;
        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (posted != null ? posted.hashCode() : 0);
        return result;
    }
}
