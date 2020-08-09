package ramdan.com.xendit.spring.boot.demo.mapping;

import org.mapstruct.*;
import ramdan.com.xendit.model.Invoice;
import ramdan.com.xendit.model.InvoiceParam;
import ramdan.com.xendit.spring.boot.demo.domain.InvoiceData;
import ramdan.com.xendit.utils.ISO8601TimeFormat;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Date;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface InvoiceMapping {
    default BigInteger toBigInteger(Number number){
        if(number instanceof BigInteger){
            return (BigInteger) number;
        }
        return BigInteger.valueOf(number.longValue());
    }
    default String toStringDate(Date date){
        return ISO8601TimeFormat.format(date);
    }
    default Date toDate(String date){
        try {
            return ISO8601TimeFormat.newInstance().parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Mapping(target = "externalId",source = "id")
    InvoiceParam toInvoice(InvoiceData data);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "xenditId",source = "id")
    @Mapping(target = "xenditUserId",source = "userId")

    void updateInvoiceData(@MappingTarget InvoiceData data,  Invoice dto);
}
