package com.csg.zhong.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by 王修智 on 2017-07-15-0015.
 */

public enum EcIcons implements Icon {

    icon_scan('\ue605'),//
    icon_ali_pay('\ue67c'),;

    char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }

}
