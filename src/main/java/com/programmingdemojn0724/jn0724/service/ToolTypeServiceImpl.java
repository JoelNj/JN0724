package com.programmingdemojn0724.jn0724.service;

import com.programmingdemojn0724.jn0724.data.ToolTypeRepository;
import com.programmingdemojn0724.jn0724.domain.ToolType;
import com.programmingdemojn0724.jn0724.service.interfaces.tooltypeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolTypeServiceImpl implements tooltypeservice {
    @Autowired
    private ToolTypeRepository toolTypeRepository;

    public ToolType save(ToolType toolType){
        return toolTypeRepository.save(toolType);
    }
    public List<ToolType> findAll(){
        return toolTypeRepository.findAll();
    }
    public ToolType getOne(Long id){
        return toolTypeRepository.getOne(id);
    }

}
