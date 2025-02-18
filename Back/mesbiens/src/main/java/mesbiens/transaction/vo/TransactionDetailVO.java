package mesbiens.transaction.vo;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mesbiens.account.vo.AccountVO;

// 거래 내역 Entity Bean 클래스

@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "transactionNo")
@Entity
@Table(name = "transaction_detail")
@SequenceGenerator(
	name = "transaction_no_seq_generator",
	sequenceName = "transaction_no_seq",
	initialValue = 1,
	allocationSize = 1
)
public class TransactionDetailVO {
	@Id
	@Column(name="TRANSACTION_no")
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "transaction_no_seq_generator"
	)
	private int transactionNo; // 거래내역No
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="receiver_account_no", referencedColumnName = "account_no")
	private AccountVO receiverAccountNo; // 수신 계좌
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sender_account_no", referencedColumnName = "account_no")
	private AccountVO senderAccountNo; // 송신 계좌
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="consumption_cate_no", referencedColumnName = "consumption_cate_no")
	private ConsumptionCategoryVO consumptionCateNo; // 소비 카테고리 코드
	
	@Enumerated(EnumType.STRING) // Enum(상수) Class만 들어갈때 사용
	@Column(name="TRNS_type_name", nullable = false)
	private TransactionType trnsTypeName; // 거래 유형명
	
	@Column(name="TRNS_balance", nullable = false)
	private Long trnsBalance; // 거래 금액
	
	@Column(name="TRNS_place", nullable = false)
	private String trnsPlace; // 거래 점포
	
	@Column(name="TRNS_memo", nullable = false)
	private String trnsMemo; // 거래 메모
	
	@Column(name="TRNS_create_at")
	@CreationTimestamp
	private LocalDateTime trnsCreateAt; // 거래 시간

}





























