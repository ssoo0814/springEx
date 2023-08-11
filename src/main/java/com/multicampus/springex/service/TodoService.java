package com.multicampus.springex.service;

import com.multicampus.springex.dto.PageRequestDTO;
import com.multicampus.springex.dto.PageResponseDTO;
import com.multicampus.springex.dto.TodoDTO;

public interface TodoService {
    void register(TodoDTO todoDTO);

    //List<TodoDTO> getAll();

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);
}
