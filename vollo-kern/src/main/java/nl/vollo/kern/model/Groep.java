package nl.vollo.kern.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "groepen")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Groep implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Version
	@Column(name = "version")
	private int version;

	@Column
    private String naam;

    @OneToMany(mappedBy = "groep", targetEntity = GroepLeerling.class, fetch = FetchType.LAZY)
    private List<GroepLeerling> groepLeerlingen;

}