package ramdan.com.xendit.spring.boot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ramdan.com.xendit.spring.boot.demo.domain.InvoiceData;

public interface InvoiceDataRepository extends JpaRepository<InvoiceData,Long> {
}
