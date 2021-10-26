# [1.0.0-alpha.4](https://github.com/giulioscattolin/rinex/compare/v1.0.0-alpha.3...v1.0.0-alpha.4) (2021-10-26)


### Bug Fixes

* parameter was always positive ([d3bbc42](https://github.com/giulioscattolin/rinex/commit/d3bbc4238b9aa7931ad8bbd592937653364925ad))


### Features

* add new parser implementation ([9df3fe2](https://github.com/giulioscattolin/rinex/commit/9df3fe2138c95be7b795e6c5d30881b5b9bda24e))
* generate equals(), hashCode() for RinexVersionTypeHeader and RinexPgmRunByDateHeader ([cb7b98c](https://github.com/giulioscattolin/rinex/commit/cb7b98ceece44fa422808eaf073e138606f32d84))


### Reverts

* deprecate current implementation ([5490616](https://github.com/giulioscattolin/rinex/commit/54906165fa5f1128111e966ee434d00d1a6e43c9))

# [1.0.0-alpha.3](https://github.com/giulioscattolin/rinex/compare/v1.0.0-alpha.2...v1.0.0-alpha.3) (2021-10-25)


### Features

* parse GPS navigation data from RINEX mixed navigation files ([c263c3f](https://github.com/giulioscattolin/rinex/commit/c263c3f77ec80e570503a255e94242dc0db9ff08))

# [1.0.0-alpha.2](https://github.com/giulioscattolin/rinex/compare/v1.0.0-alpha.1...v1.0.0-alpha.2) (2021-10-25)


### Features

* parse "MARKER NAME" header in observation data file V210 ([0ea8331](https://github.com/giulioscattolin/rinex/commit/0ea83316a84eef4bb2d4ee0b55a09905416bda79))
* parse "OBSERVER / AGENCY" header in observation data file V210 ([1928ea0](https://github.com/giulioscattolin/rinex/commit/1928ea0c4da9b5755af69432024c2349043df868))
* parse "RINEX VERSION / TYPE" in observation data file V210 ([9d5c741](https://github.com/giulioscattolin/rinex/commit/9d5c741b1e927145d5cea19668c3b5da1db3e5a3))

# 1.0.0-alpha.1 (2021-10-23)


### Features

* add PGM / RUN BY / DATE header ([fc32f42](https://github.com/giulioscattolin/rinex/commit/fc32f42489651bdcce76a8c528ffd310916b4327))
* add RinexFileParser and RinexFile ([1abd19b](https://github.com/giulioscattolin/rinex/commit/1abd19b7d30756b04ef1175cf6a2a5577d16a140))
* add RinexVersionType header ([83e2889](https://github.com/giulioscattolin/rinex/commit/83e288933dd3f3428a3446abdbc75023db29ec39))
* implement initial GPS navigation message parser ([2c61a13](https://github.com/giulioscattolin/rinex/commit/2c61a138f8404ad4e3f685e9662beb91d248ef04))
* rename RinexVersionType to RinexVersionTypeHeader ([8c2199b](https://github.com/giulioscattolin/rinex/commit/8c2199b8be13a23b8ddcaf3770f551d728dc07e1))
