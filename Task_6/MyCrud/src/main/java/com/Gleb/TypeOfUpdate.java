package com.Gleb;

public enum TypeOfUpdate { // добавить в createStatement ещё и добавление с id, выбор действия енамом
                            // и тогда использовать добавление с id в сервисе в апдейте, когда такой записи нет
    ADD,

    UPDATE,

    ADD_WITH_ID;
}
