package com.codedojo.exerciseprovider.model.language;



import lombok.*;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @Getter
    private String code;

    @Column
    @Getter
    private String description;

}
