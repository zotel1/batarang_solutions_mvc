package com.batarang_solutions_mvc.demo.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
