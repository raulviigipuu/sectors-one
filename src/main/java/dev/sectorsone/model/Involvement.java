package dev.sectorsone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity(name = "involvement")
public class Involvement extends BaseEntity {
    @Column(nullable = false)
    @NotBlank
    private String name;
    @NotNull
    @AssertTrue
    private Boolean agreeToTerms = false;
    @NotEmpty
    @ManyToMany
    private List<Sector> sectorList;

    public String toString() {
        return String.format("Sector [id=%d, name=%s, agreeToTerms=%b, sectors=%s]",
                this.getId(), this.name, this.agreeToTerms,
                this.sectorList.stream().map(s -> s.getName()).collect(Collectors.joining(",")));
    }
}
