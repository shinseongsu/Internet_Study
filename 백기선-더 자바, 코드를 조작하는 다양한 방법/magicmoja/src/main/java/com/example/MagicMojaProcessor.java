package com.example;

import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.Name;
import javax.tools.Diagnostic;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

@AutoService(Processor.class)
public class MagicMojaProcessor extends AbstractProcessor {

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Magic.class.getName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Magic.class);

        for (Element element : elements) {
            Name elementName = element.getSimpleName();
            if (element.getKind() != ElementKind.INTERFACE) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "Magic annotation can not be used on" + elementName);
            } else {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Processing " + elementName);
            }

            TypeElement typeElement = (TypeElement) element;
            ClassName className = ClassName.get(typeElement);

            MethodSpec pullOut = MethodSpec.methodBuilder("pullOut").addModifiers(Modifier.PUBLIC).returns(String.class)
                    .addStatement("return $S", "Rabbit!").build();

            TypeSpec MagicMoja = TypeSpec.classBuilder("MagicMoja").addModifiers(Modifier.PUBLIC)
                    .addSuperinterface(className).addMethod(pullOut).build();

            Filer filer = processingEnv.getFiler();
            try {
                JavaFile.builder(className.packageName(), MagicMoja).build().writeTo(filer);
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "FATAL ERROR: " + e);
            }
        }

        return true;
    }
}
