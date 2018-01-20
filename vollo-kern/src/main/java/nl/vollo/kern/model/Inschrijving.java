package nl.vollo.kern.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "inschrijvingen")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Inschrijving implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vollo_seq")
    @SequenceGenerator(name = "vollo_seq", sequenceName = "vollo_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
    private Long id;

	@Version
	@Column(name = "version")
	private int version;

	@ManyToOne(targetEntity = Leerling.class)
    @JoinColumn(name = "leerling_id", foreignKey = @ForeignKey(name = "ins_llg_fk"))
	private Leerling leerling;

	@Column(name = "datum_inschrijving", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datumInschrijving;

	@Column(name = "datum_uitschrijving")
    @Temporal(TemporalType.DATE)
    private Date datumUitschrijving;

}