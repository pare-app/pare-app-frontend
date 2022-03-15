package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.backend.ProtectedBackEndClient;

public abstract class AbstractEntityService <T>{
    protected abstract ProtectedBackEndClient<T> getBackEndClient();

    public T get(Integer id) {
        return getBackEndClient().doGetById(id).getBody();
    }
}
