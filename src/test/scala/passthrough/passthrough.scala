package passthrough

import chisel3._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.freespec.AnyFreeSpec


class PassthroughTest extends AnyFreeSpec with ChiselSim {
  "test" in {
    simulate(new PassthroughGenerator(10)) { c =>
      c.io.in.poke(0.U)
      c.io.out.expect(0.U)
      c.io.in.poke(1023.U)
      c.io.out.expect(1023.U)
    }
  }
}
