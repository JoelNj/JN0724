package com.programmingdemojn0724.jn0724.service;


import com.programmingdemojn0724.jn0724.data.ToolRepository;
import com.programmingdemojn0724.jn0724.domain.Tool;
import com.programmingdemojn0724.jn0724.service.interfaces.toolservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolServiceImpl implements toolservice {

    @Autowired
    ToolRepository toolRepository;

    public Tool save(Tool tool){
        return toolRepository.save(tool);
    }

    public Tool getOne(String toolCode){
        return toolRepository.findByToolCode(toolCode);
    }

    public List<Tool> getAll(){
        return toolRepository.findAll();
    }

}
