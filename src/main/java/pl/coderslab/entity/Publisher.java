package pl.coderslab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
@ToString(exclude = "books")
@Setter
@Getter
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "publisher")
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<Book> books = new ArrayList<>();

    @NIP
    private String nip;
    @REGON
    private String regon;
}