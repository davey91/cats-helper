/**
 * Copyright 2025 Evolution
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.evolutiongaming.catshelper.syntax

import com.evolutiongaming.catshelper.Log

/**
 * This code is inspired by https://github.com/typelevel/log4cats/blob/3fc1cc303ac8b6d177057c05618bd396aa03bfc9/core/shared/src/main/scala/org/typelevel/log4cats/syntax/package.scala
 * It only differs in using com.evolutiongaming.catshelper.Log instead of org.typelevel.log4cats.Logger
 *
 * Tiny syntax code to log like a string interpolator.
 * e.g. info"App starting.."
 */
object LoggerInterpolatorSyntax {

  implicit final class Interpolator(private val sc: StringContext) extends AnyVal {
    def error[F[_]](message: Any*)(implicit logger: Log[F]): F[Unit] =
      logger.error(sc.s(message: _*))

    def warn[F[_]](message: Any*)(implicit logger: Log[F]): F[Unit] =
      logger.warn(sc.s(message: _*))

    def info[F[_]](message: Any*)(implicit logger: Log[F]): F[Unit] =
      logger.info(sc.s(message: _*))

    def debug[F[_]](message: Any*)(implicit logger: Log[F]): F[Unit] =
      logger.debug(sc.s(message: _*))

    def trace[F[_]](message: Any*)(implicit logger: Log[F]): F[Unit] =
      logger.trace(sc.s(message: _*))
  }
}
