package pl.mybookapp;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "authors")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String fullName;

}
