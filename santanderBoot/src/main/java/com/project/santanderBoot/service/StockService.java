package com.project.santanderBoot.service;

import com.project.santanderBoot.exceptions.BusinessException;
import com.project.santanderBoot.mapper.StockMapper;
import com.project.santanderBoot.model.Stock;
import com.project.santanderBoot.model.dto.StockDTO;
import com.project.santanderBoot.repository.StockRepository;
import com.project.santanderBoot.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.prefs.BackingStoreException;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto){
        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(),dto.getDate());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

}
