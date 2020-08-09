package ramdan.com.xendit.spring.boot.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ramdan.com.xendit.endpoint.InvoiceCreateEndpoint;
import ramdan.com.xendit.spring.boot.demo.domain.InvoiceData;
import ramdan.com.xendit.spring.boot.demo.mapping.InvoiceMapping;
import ramdan.com.xendit.spring.boot.demo.repository.InvoiceDataRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
@Slf4j
public class CreateInvoiceController {

    InvoiceCreateEndpoint invoiceCreateEndpoint;
    InvoiceDataRepository invoiceDataRepository;
    InvoiceMapping invoiceMapping;

    @GetMapping("/invoice")
    public String getList(){
        return "invoice-list.html";
    }

    @GetMapping("/invoice/create")
    public String getForm(Model model){

        model.addAttribute("data",new InvoiceData());
        return "invoice_create.html";
    }

    @PostMapping("/invoice/create")
    @Transactional
    public String create(@Valid InvoiceData data,
                         BindingResult bindingResult,
                         Model model){

        if(bindingResult.hasErrors()){
            log.error("invalid data");
            model.addAttribute("data",data);
            return "invoice_create.html";
        }
        data = invoiceDataRepository.saveAndFlush(data);
        log.info("Internal ID : {}",data.getId());
        val invoiceParam = invoiceMapping.toInvoice(data);
        val invoice = invoiceCreateEndpoint.create(invoiceParam);

        log.info("Xendit ID   : {}",invoice.getId());
        log.info("Invoice Url : {}",invoice.getInvoiceUrl());
        invoiceMapping.updateInvoiceData(data,invoice);
        data = invoiceDataRepository.saveAndFlush(data);
        model.addAttribute("data",data);

        return "invoice_created.html";
    }
}
