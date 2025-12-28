package passthrough


import chisel3._
import _root_.circt.stage.ChiselStage
//import chisel3.util._
//import chisel3.tester._
//import chisel3.tester.RawTester.test
//import dotvisualizer._


class PassthroughGenerator(width: Int) extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(width.W))
    val out = Output(UInt(width.W))
  })
  io.out := io.in
}


/**
 * Generate Verilog sources and save it in file GCD.v
 */
object Passthrough extends App {
  ChiselStage.emitSystemVerilogFile(
    new PassthroughGenerator(10),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info", "-default-layer-specialization=enable")
  )
}
