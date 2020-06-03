/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.rxjava3.http.client;

import io.micronaut.core.io.buffer.ByteBuffer;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.sse.SseClient;
import io.micronaut.http.sse.Event;
import io.reactivex.rxjava3.core.Flowable;

/**
 * RxJava 3 variation of the {@link SseClient} interface.
 *
 * @author graemerocher
 * @since 1.0.0
 */
public interface Rx3SseClient extends SseClient {
    @Override
    <I> Flowable<Event<ByteBuffer<?>>> eventStream(HttpRequest<I> request);

    @Override
    <I, B> Flowable<Event<B>> eventStream(HttpRequest<I> request, Argument<B> eventType);

    @Override
    <I, B> Flowable<Event<B>> eventStream(HttpRequest<I> request, Class<B> eventType);

    @Override
    <B> Flowable<Event<B>> eventStream(String uri, Class<B> eventType);

    @Override
    <B> Flowable<Event<B>> eventStream(String uri, Argument<B> eventType);
}
