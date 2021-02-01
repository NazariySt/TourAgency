package model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roomsType")
public class RoomType {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @ManyToOne
    private Hotel hotel;

    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomType roomType = (RoomType) o;
        return Objects.equals(id, roomType.id) && Objects.equals(type, roomType.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
