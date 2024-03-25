package TO_G1Spring61.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "requestsNew")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="ID")
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = false)
    private String userName;

    @Column(name = "COURSENAME")
    private String courseName;

    @Column(name = "COMMENTARY", columnDefinition = "TEXT")
    private String commentary;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "HANDLED", columnDefinition = "BOOLEAN default false")
    private Boolean handled = false;

    @ManyToOne
    private Course course;
}
