package dev.sectorsone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "sector")
public class Sector extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Sector parent;
    @OneToMany(mappedBy = "parent")
    private List<Sector> subSectorList;
    @ManyToMany
    private List<Involvement> involvementList;

    public String toString() {
        return String.format("Sector [id=%d, name=%s]", this.getId(), this.name);
    }
}