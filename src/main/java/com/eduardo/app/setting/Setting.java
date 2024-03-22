package com.eduardo.app.setting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Setting<T> {
    public String key;
    public T value;

    @Override
    public String toString() {
        return key;
    }
}
