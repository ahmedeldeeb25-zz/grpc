// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: calculator/calc.proto

package com.proto.calculator;

public final class Calc {
  private Calc() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greet_SumRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greet_SumRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greet_SumResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greet_SumResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025calculator/calc.proto\022\005greet\"9\n\nSumReq" +
      "uest\022\024\n\014first_number\030\001 \001(\005\022\025\n\rsecond_num" +
      "ber\030\002 \001(\005\"!\n\013SumResponse\022\022\n\nsum_result\030\001" +
      " \001(\0052C\n\021calculatorService\022.\n\003Sum\022\021.greet" +
      ".SumRequest\032\022.greet.SumResponse\"\000B\030\n\024com" +
      ".proto.calculatorP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_greet_SumRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_greet_SumRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greet_SumRequest_descriptor,
        new java.lang.String[] { "FirstNumber", "SecondNumber", });
    internal_static_greet_SumResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_greet_SumResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greet_SumResponse_descriptor,
        new java.lang.String[] { "SumResult", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}