require cryptodev.inc

SUMMARY = "A /dev/crypto device driver kernel module"

inherit module

# Header file provided by a separate package
DEPENDS += "cryptodev-linux"

SRC_URI += " \
file://0001-Disable-installing-header-file-provided-by-another-p.patch \
file://0001-Fix-build-for-Linux-5.8-rc1.patch \
file://0001-Fix-build-for-Linux-5.9-rc1.patch \
file://fix-build-for-Linux-5.11-rc1.patch \
"

EXTRA_OEMAKE='KERNEL_DIR="${STAGING_KERNEL_DIR}" PREFIX="${D}"'

RCONFLICTS_${PN} = "ocf-linux"
RREPLACES_${PN} = "ocf-linux"
