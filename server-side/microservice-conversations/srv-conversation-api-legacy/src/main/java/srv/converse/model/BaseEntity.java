package srv.converse.model;

import java.util.Date;

/**
 * @author vladimir.fedotov
 * @since 06-Dec-19
 */
public abstract class BaseEntity  {

    private Long id;
    private Date updatedAt;
    private Date createdAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
