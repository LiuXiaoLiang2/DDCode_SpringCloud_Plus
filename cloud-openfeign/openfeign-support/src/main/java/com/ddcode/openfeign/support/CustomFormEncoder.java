/*
 * Copyright 2018 Artem Labazin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ddcode.openfeign.support;

import static feign.form.ContentType.MULTIPART;
import static java.util.Collections.singletonMap;

import java.lang.reflect.Type;

import org.springframework.web.multipart.MultipartFile;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import feign.form.MultipartFormContentProcessor;
import feign.form.spring.SpringManyMultipartFilesWriter;
import feign.form.spring.SpringSingleMultipartFileWriter;
import lombok.val;

/**
 * Adds support for {@link MultipartFile} type to {@link FormEncoder}.
 *
 * @author Tomasz Juchniewicz &lt;tjuchniewicz@gmail.com&gt;
 * @since 14.09.2016
 */
public class CustomFormEncoder extends FormEncoder {

  /**
   * Constructor with the default Feign's encoder as a delegate.
   */
  public CustomFormEncoder () {
    this(new Default());
  }

  /**
   * Constructor with specified delegate encoder.
   *
   * @param delegate  delegate encoder, if this encoder couldn't encode object.
   */
  public CustomFormEncoder (Encoder delegate) {
    super(delegate);

    val processor = (MultipartFormContentProcessor) getContentProcessor(MULTIPART);
    processor.addFirstWriter(new SpringSingleMultipartFileWriter());
    processor.addFirstWriter(new SpringManyMultipartFilesWriter());
  }

  @Override
  public void encode (Object object, Type bodyType, RequestTemplate template) throws EncodeException {
//    if (!bodyType.equals(MultipartFile.class)) {
//      super.encode(object, bodyType, template);
//      return;
//    }
//
//    val file = (MultipartFile) object;
//    val data = singletonMap(file.getName(), object);
//    super.encode(data, MAP_STRING_WILDCARD, template);
	  
		if (bodyType.equals(MultipartFile.class)) {
			val file = (MultipartFile) object;
			val data = singletonMap(file.getName(), object);
			super.encode(data, MAP_STRING_WILDCARD, template);
			return;
		} else if (bodyType.equals(MultipartFile[].class)) {
			val file = (MultipartFile[]) object;
			if (file != null) {
				val data = singletonMap(file.length == 0 ? "" : file[0].getName(), object);
				super.encode(data, MAP_STRING_WILDCARD, template);
				return;
			}
		}
		super.encode(object, bodyType, template);
	}
  
}
