/*
 * Copyright (c) 2012, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.glassfish.jersey.server.validation.internal;

import jakarta.ws.rs.container.ResourceContext;
import jakarta.ws.rs.core.Context;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;

/**
 * {@link ConstraintValidatorFactory} with support of injecting Jersey providers/resources.
 *
 * @author Michal Gajdos
 */
public class InjectingConstraintValidatorFactory implements ConstraintValidatorFactory {

    @Context
    private ResourceContext resourceContext;

    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(final Class<T> key) {
        return resourceContext.getResource(key);
    }

    @Override
    public void releaseInstance(final ConstraintValidator<?, ?> instance) {
        // NOOP
    }
}
