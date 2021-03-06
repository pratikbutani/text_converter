/*
 * Copyright (C)  2017-2018 Tran Le Duy
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.duy.text.converter.core.codec;

import com.duy.text.converter.core.codec.interfaces.Codec;
import com.duy.text.converter.core.codec.interfaces.CodecMethod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Duy on 2/10/2018.
 */
public class AsciiCodecTest {
    public static final String UTF_16_STR = "💧";
    private static final String TO_BE_ENCODE = "hello";
    private static final String TO_BE_DECODE = "104 101 108 108 111";

    @Test
    public void encode() throws Exception {
        Codec codec = CodecMethod.ASCII.getCodec();
        String result = codec.encode(TO_BE_ENCODE);
        assertEquals(result, TO_BE_DECODE);
    }

    @Test
    public void encodeUtf16() throws Exception {
        Codec codec = CodecMethod.ASCII.getCodec();
        String encoded = codec.encode(UTF_16_STR);
        assertEquals("128167", encoded);
    }

    @Test
    public void decodeUtf16() throws Exception {
        Codec codec = CodecMethod.ASCII.getCodec();
        String decoded = codec.decode(codec.encode(UTF_16_STR));
        assertEquals(UTF_16_STR, decoded);
    }

    @Test
    public void decode() throws Exception {
        Codec codec = CodecMethod.ASCII.getCodec();
        String result = codec.decode(TO_BE_DECODE);
        assertEquals(result, TO_BE_ENCODE);
    }

}