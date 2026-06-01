package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.impl;

import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.dtos.InvoiceDTO;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.exceptions.ResourceNotFoundException;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.mappers.InvoiceMapper;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.Invoice;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.models.ServiceRecord;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.InvoiceRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.repositories.ServiceRecordRepository;
import com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ServiceRecordRepository serviceRecordRepository;
    private final InvoiceMapper invoiceMapper;

    @Override
    public InvoiceDTO create(InvoiceDTO dto) {

        ServiceRecord serviceRecord =
                serviceRecordRepository.findById(dto.getServiceRecordId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Service record not found"));

        Invoice invoice = invoiceMapper.toEntity(dto);
        invoice.setServiceRecord(serviceRecord);

        return invoiceMapper.toDTO(
                invoiceRepository.save(invoice)
        );
    }

    @Override
    public InvoiceDTO update(Long id, InvoiceDTO dto) {

        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invoice not found"));

        ServiceRecord serviceRecord =
                serviceRecordRepository.findById(dto.getServiceRecordId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Service record not found"));

        invoice.setAmount(dto.getAmount());
        invoice.setServiceRecord(serviceRecord);

        return invoiceMapper.toDTO(
                invoiceRepository.save(invoice)
        );
    }

    @Override
    public InvoiceDTO getById(Long id) {

        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invoice not found"));

        return invoiceMapper.toDTO(invoice);
    }

    @Override
    public Page<InvoiceDTO> getAll(Pageable pageable) {

        return invoiceRepository
                .findAll(pageable)
                .map(invoiceMapper::toDTO);
    }

    @Override
    public void delete(Long id) {

        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invoice not found"));

        invoiceRepository.delete(invoice);
    }
}