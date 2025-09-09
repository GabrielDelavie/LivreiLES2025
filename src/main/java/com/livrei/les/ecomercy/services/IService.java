package com.livrei.les.ecomercy.services;

import com.livrei.les.ecomercy.application.Result;

public interface IService<T> {

    Result findAll();

    Result findById(Long id);

    Result insert(T obj);

    Result update(Long id, T obj);

    Result delete(Long id);
}
