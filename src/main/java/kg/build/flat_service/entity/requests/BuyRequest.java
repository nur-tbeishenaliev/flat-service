package kg.build.flat_service.entity.requests;

import jakarta.persistence.*;
import kg.build.flat_service.entity.account.User;
import kg.build.flat_service.enums.ObjectStatus;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Entity
@Table(name = "buy_request")
@Data
@Accessors(chain = true)
public class BuyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "buy_request_seq")
    @SequenceGenerator(
            name = "buy_request_seq",
            sequenceName = "buy_request_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ObjectStatus status;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_for_process_id")
    private User userForProcess;

}
