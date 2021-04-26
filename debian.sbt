import Common.{betaVersion, snapshotVersion, stableVersion, versionUsage}

Debian / linuxPackageMappings += packageMapping(file("LICENSE") -> "/usr/share/doc/thehive/copyright").withPerms("644")
Debian / name := "thehive4"
Debian / version := {
  version.value match {
    case stableVersion(_, _)                      => version.value
    case betaVersion(v1, v2, v3)                  => v1 + "-0." + v3 + "RC" + v2
    case snapshotVersion(stableVersion(v1, v2))   => v1 + "-" + v2 + "-SNAPSHOT"
    case snapshotVersion(betaVersion(v1, v2, v3)) => v1 + "-0." + v3 + "RC" + v2 + "-SNAPSHOT"
    case _                                        => versionUsage(version.value)
  }
}
debianPackageConflicts += "thehive"
debianPackageDependencies += "java8-runtime-headless"
Debian / maintainerScripts := maintainerScriptsFromDirectory(
  baseDirectory.value / "package" / "debian",
  Seq(DebianConstants.Postinst, DebianConstants.Prerm, DebianConstants.Postrm)
)
Debian / linuxMakeStartScript := None
