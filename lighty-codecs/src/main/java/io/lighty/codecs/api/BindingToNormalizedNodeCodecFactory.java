/*
 * Copyright (c) 2018 Pantheon Technologies s.r.o. All Rights Reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at https://www.eclipse.org/legal/epl-v10.html
 */
package io.lighty.codecs.api;

import javassist.ClassPool;
import org.opendaylight.controller.md.sal.binding.impl.BindingToNormalizedNodeCodec;

import org.opendaylight.mdsal.binding.dom.codec.gen.impl.StreamWriterGenerator;
import org.opendaylight.mdsal.binding.dom.codec.impl.BindingNormalizedNodeCodecRegistry;
import org.opendaylight.mdsal.binding.generator.api.ClassLoadingStrategy;
import org.opendaylight.mdsal.binding.generator.util.JavassistUtils;

public class BindingToNormalizedNodeCodecFactory {

    public static final ClassPool CLASS_POOL = ClassPool.getDefault();
    public static final JavassistUtils JAVASSIST = JavassistUtils.forClassPool(CLASS_POOL);

    /**
     * Creates a new BindingToNormalizedNodeCodec instance.
     *
     * @param classLoadingStrategy
     * @return the BindingToNormalizedNodeCodec instance
     */
    public static BindingToNormalizedNodeCodec newInstance(final ClassLoadingStrategy classLoadingStrategy) {
        final BindingNormalizedNodeCodecRegistry codecRegistry = new BindingNormalizedNodeCodecRegistry(
                StreamWriterGenerator.create(JAVASSIST));
        return new BindingToNormalizedNodeCodec(classLoadingStrategy, codecRegistry, true);
    }

}
